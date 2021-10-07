boolean success(String message) {
    currentBuild.result = 'SUCCESS'
    echo message
    return false;
}

boolean shouldRun() {
    String message = sh(label: 'Get Commit Message', script: 'git log -1 --pretty=%B', returnStdout: true).trim()

    if (message.matches('.*\\[skip ci].*')) {
        return success('[skip] commit message contains [skip ci]')
    } else if (env.BRANCH_NAME != 'master' && message.matches("^\\[release] 'v.*")) {
        return success('[skip] only build releases on the master branch')
    } else {
        return true
    }
}

void toolSh(String command) {
    container('java-buildtools') {
        sh command
    }
}
pipeline {
    agent {
        kubernetes {
            yamlFile 'jenkins-agent.yml'
            defaultContainer 'tools'
            podRetention never()

        }
    }
    environment {
        TEST_CRED = credentials('TEST_CRED')
        SAUCE_USERNAME = credentials('SAUCE_USERNAME')
        SAUCE_ACCESS_KEY=credentials('SAUCE_ACCESS_KEY')
    }
    stages {

        stage('Run CI?') {
            when { expression { shouldRun() } }
            stages {
                stage('Environment Variables') {
                    steps { sh 'env | sort' }
                }
                stage('Credentials') {
                    environment {
                        GITHUB_CREDENTIALS = credentials('github_daws_svc_account')
                        ARTIFACTORY_CREDENTIALS = credentials('artifactory_serv_svc_dawsdev')
                        SONARQUBE_TOKEN = credentials('sonarqube_serv_svc_dawsdev')
                    }
                    steps {
                        toolSh 'github-credentials.sh'
                        toolSh 'artifactory-credentials.sh'
                        toolSh 'sonarqube-credentials.sh'
                    }
                }
                stage('Publish') {
                    steps { toolSh 'gradle artifactoryPublish' }
                }
            }
        }
    }
}
