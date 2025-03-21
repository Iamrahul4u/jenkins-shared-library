#!/usr/bin/env groovy
package com.example
class Docker implements   Serializable{

    def script
    Docker (script){
        this.script=script
    }
    def dockerBuildImage(String imageName){
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}