#!/bin/bash
export CIRCLE_BUILD_NUM_DOCKER=0.1.1
sed "s/BUILD_VERSION/$CIRCLE_BUILD_NUM_DOCKER/g" product-service-kube.yaml > build/product-service-kube.yaml
kubectl apply -f build/product-service-kube.yaml
