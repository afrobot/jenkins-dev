#!/usr/bin/env groovy

/**
 * Jenkins job must be parametrized
 *
 * devRepo       - url to development version of repo
 * prodRepo      - url to production version of repo
 * credentialsId - credentials
 */

node {
  try {

    stage('setup') {
      checkout scm
      
      sh 'git show-ref --head'
      step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'jenkins']])
    }


    stage('build') {
      // ...
    }


    stage('test') {
      // ...
    }


    stage('sync-master') {
      sshagent([credentialsId]) {
        sh "git remote add prod ${prodRepo}"
        sh '''
          echo ${prodRepo}
          git fetch --all
          git checkout -b master origin/master

          # remove non-production tags
          git tag | grep -v "^[0-9.]*$" | xargs git tag -d

          # do the synchronization between origin/master and prod/master
          git push prod master --tags
          git remote remove prod
          sh 'git show-ref --head'
        '''
      }
    }

    currentBuild.result = 'SUCCESS'

  } catch(e) {
    currentBuild.result = 'FAILURE'
    throw(e)

  } finally {

    stage('cleanup') {
      step([$class: 'GitHubCommitStatusSetter', contextSource: [$class: 'ManuallyEnteredCommitContextSource', context: 'jenkins']])
    }

  }
}
