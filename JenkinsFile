pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                sh 'mvn clean install'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Deploy'){
            steps{
                echo "Simulando un despliegue a un servidor de aplicaciones"
            }
        }

    }
    post {
        always{
            echo "Siempre se ejecutara"
        }
        success{
            echo "Este bloque se ejecuta si todo el pipeline ejecuta exitosamente"
        }
        failure{
            echo "Este bloque se ejecuta si el pipeline falla"
        }

    }


}