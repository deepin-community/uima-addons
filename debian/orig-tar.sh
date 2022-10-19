#!/bin/sh -e

# $2 version
# $3 original tarball
ZIP=$3
TAR=uima-addons_$2.orig.tar.gz
DIR=uima-addons-$2

# clean up the upstream tarball
unzip $ZIP
GZIP=--best tar -c -z -f $TAR -X debian/orig-tar.exclude $DIR
rm -rf $DIR
rm $3

exit 0
