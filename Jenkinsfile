#!/usr/bin/env groovy

stage 'build'
  node {
    sh """
      git show-ref
      git tag
    """
  }
