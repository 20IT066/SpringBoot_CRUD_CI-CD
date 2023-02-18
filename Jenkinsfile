pipeline {
    agent any

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building the react application"
                    sh 'mvn package'




                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image and restart container..."
                    //gv.buildImage()
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-pm310', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]){
                        sh 'docker build -t pm310/spring-app:ra-2.0 .'
                        sh 'docker login -u $USERNAME -p $PASSWORD'
                        sh 'docker push pm310/spring-app:ra-2.0'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying the application on ec2"
                    //gv.deployApp()

                    def dockerCmd="docker run -p 8080:8080 --name ec2-spring -d pm310/spring-app:ra-2.0"
                    def dockerStop="docker stop ec2-spring"
                    def dockerDelete="docker rm ec2-spring"
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@54.95.222.132 ${dockerStop}"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@54.95.222.132 ${dockerDelete}"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@54.95.222.132 ${dockerCmd}"


                    }
                }
            }
        }
    }
}
