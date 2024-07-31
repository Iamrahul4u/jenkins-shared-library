#!/usr/bin/env groovy

def call(){
    echo 'Building Jar File'
    sh '''
        mvn package
        ls -a
        
        '''
}