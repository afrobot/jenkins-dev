#!/usr/bin/env groovy

devRepo = 'git@github.com:afrobot/jenkins-dev.git'
prodRepo = 'git@github.com:afrobot/jenkins-prod.git'

node {
  stage("init") {
    checkout scm
  }

  stage("build") {
  }

  stage("tests") {
  }

  stage("sync-master") {
    // git remote add prod ...
    checkout([
      $class:'GitSCM',
      extensions: [[$class: 'WipeWorkspace']],
      userRemoteConfigs: [
        [credentialsId: 'github-afrobot', url: "${prodRepo}", name: 'prod'],
        [credentialsId: 'github-afrobot', url: "${devRepo}",  name: 'origin']
      ]])
    // checkout again to correct sha1
    checkout scm

    sshagent(['github-afrobot']) {
      sh '''
        git fetch --all
        git checkout master

        # remove non-production tags
        git tag | grep -v "^[0-9.]*$" | xargs git tag -d

        # do the synchronization between origin/master and prod/master
        git push prod master --tags
      '''
    }
  }

}
