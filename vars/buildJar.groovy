#!/usr/bin/env groovy

def call(){
    echo 'Building Jar File'
    sh '''
        ls -a
        mvn package
        '''
}