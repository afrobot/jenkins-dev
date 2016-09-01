#!/usr/bin/env groovy

stage 'build'
  node {
    checkout scm

    sh 'git rev-parse --abbrev-ref HEAD'
    def branch = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD')

    echo branch
  }
