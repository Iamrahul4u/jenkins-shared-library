#!/usr/bin/env groovy

def call(){
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t iamrahul4u/java-maven-app-devops:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push iamrahul4u/java-maven-app-devops:1.1'
    }
}