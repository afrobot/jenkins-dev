#!/usr/bin/env groovy

stage 'build'
  node {
    checkout scm

    def branch = sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD')

    echo branch
  }
