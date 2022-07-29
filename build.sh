#!/bin/bash

# PlanetFactory Build System for Mac/Linux
# Rev 1.0

echo $1

ROOTDIR=$(pwd)

#Test java and javac
javac --version
if (($? != 0))
then
    echo "Error: no java found on your build system. Halting"
    exit 1
fi
java --version
if (($? != 0))
then
    echo "Error: no java found on your build system. Halting"
    exit 1
fi

if test -z $1
then
    # Assuming basic debug build
    set targ = build
else
    set targ = $1
fi

cd $ROOTDIR

echo $(test -z $1)

case $targ in
    build)
        cd src
        javac --target 16 --source 16 -d ../out com/surge/pfactory/Main.java
        ;;
    run)
        cd src
        javac --target 16 --source 16 -d ../out com/surge/pfactory/Main.java
        cd ../out
        java com.surge.pfactory.Main
        ;;
    package)
        # Creates a JAR file
        echo "Currently unavailable."
        exit -1
        #TODO
        ;;
    
    *)
        echo "Unknown build type $targ"
        exit 1
        ;;
esac

echo "Build complete."

cd $ROOTDIR