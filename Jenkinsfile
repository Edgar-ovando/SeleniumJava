pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            agent {
                docker {
                     image 'maven:3.9.6-eclipse-temurin-17'
                     args '-u root:root'
                }
            }
            steps {
                sh 'mvn test'

            }
        }

        stage('Deploy') {
            steps {
                echo 'Simulando un despliegue a un servidor de aplicaciones'
            }
        }
    }

    post {
        always {
            echo 'Siempre se ejecutará'
        }
        success {
            echo 'Pipeline ejecutado exitosamente ✅'
        }
        failure {
            echo 'El pipeline falló ❌'
        }
    }
}
