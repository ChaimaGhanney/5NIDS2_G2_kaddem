pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout the code from the repository
                    checkout scm
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
            sh 'mvn clean test -Dspring.profiles.active=test'
            }
        }
        stage('SonarQube Analysis') {
                    steps {
                        withSonarQubeEnv('SonarQubeServer') {
                            script {
                                sh 'mvn sonar:sonar'
                            }
                        }
                    }
                }
        stage('Nexus Deployment') {
                    steps {

                              sh "mvn deploy -DskipTests"
                                     }
                               }
        stage('Prometheus And Grafana'){
                            steps {

                                sh "docker start prometheus"
                        	    sh "docker start grafana"
                        		}
                        	}
        stage('Building Docker image') {
                	   steps {
                		 script {
                			// Generating image from Dockerfile
                			  sh 'docker build -t hamzabenmhenni/hamzabenmhenni-5nids2-g2.jar .'
                			}
                		 }
                	    }
                stage('Push Docker Image') {
                    steps {


                        // Log in to Docker Hub with your credentials
                        withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                            sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                        }

                        // Push the Docker image to Docker Hub
                        sh "docker push hamzabenmhenni/hamzabenmhenni-5nids2-g2.jar"
                    }
                }
              stage('Docker Compose Deployment') {
                          steps {
                              script {


                                  // Run Docker Compose with the downloaded JAR file
                                  sh 'docker-compose -f docker-compose.yml up -d'
                              }
                          }
                      }
        stage('Nmap Scan') {
            steps {
                script {
                    // Run Nmap scan
                    sh 'nmap 192.168.33.10'
                }
            }
        }
        stage('SQLMap Scan') {
            steps {
                script {
                    // Run SQLMap scan
                    sh 'sqlmap -u http://192.168.33.10:8090/kaddem/departement/retrieve-departement/1'
                }
            }
        }
        stage('OWASP Dependency Check') {
          steps {
        dependencyCheck additionalArguments: '''
           -o './'
           -s './'
           -f 'ALL'
           --prettyPrint''', odcInstallation: 'DP-check'
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
    }
}


    }
}
