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
                                  // Download the JAR file from Nexus
                                  sh 'curl -o hamza.jar -L http://192.168.33.10:8081/repository/maven-releases/tn/esprit/spring/kaddem/0.0.1/kaddem-0.0.1.jar'

                                  // Run Docker Compose with the downloaded JAR file
                                  sh 'docker-compose -f docker-compose.yml up -d'
                              }
                          }
                      }

    }
}