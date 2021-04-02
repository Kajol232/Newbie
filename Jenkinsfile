pipeline {
    agent {
        docker{
            image 'maven:3.6.3-openjdk-15-slim'
            args '-v /root/.m2:/root/.m2'
        }
    }
   
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
