pipeline {
    agent {
        label 'projectweek' 
    }

    environment {
        PROJECT_NAME = pwd().find(/(?<=_).*(?=_)/)
    }

    stages {
        stage('build') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('test'){
            steps {
                sh 'rm -rf /usr/local/tomcat/webapps/ROOT'
                sh 'cp -r target/*.war /usr/local/tomcat/webapps/ROOT.war'
                sh '/usr/local/tomcat/bin/startup.sh'
                sh 'mvn clean verify'
            }
        }

        stage('deploy') {
            steps {
                sshagent(credentials: ['fd562910-3591-41b1-ac16-de98108e2b61']) {
                    sh "scp -P 22345 -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null target/*.war build@tomcat.projectweek.be:/opt/tomcat/teams/${env.PROJECT_NAME}/ROOT.war"
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
