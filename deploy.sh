#!/usr/bin/env bash

set -e

echo "====Updating SSH Config===="

echo "
Host ec2-54-223-95-220.cn-north-1.compute.amazonaws.com.cn
    User ubuntu
" >> ~/.ssh/config

echo "====SSH Config Updated===="
scp product-service-kube.yaml ec2-54-223-95-220.cn-north-1.compute.amazonaws.com.cn:/tmp/product-service-kube.yaml
ssh ec2-54-223-95-220.cn-north-1.compute.amazonaws.com.cn '
set -e
kubectl apply -f /tmp/product-service-kube.yaml
