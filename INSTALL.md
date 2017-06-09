Create a working directory to clone all source codes into :

$ mkdir project
$ cd project

Install the language server along with the supported version of dotty :

$ git clone --recursive https://github.com/flonso/dotty
$ cd dotty 
$ git checkout vscode
$ git submodule update --init
$ sbt
$ > sbt-dotty/publishLocal # publish local only sbt-dotty for now
$ > exit
$ cd .. # you should now be inside "project" folder


Clone and install Stainless :
$ git clone https://github.com/flonso/stainless
$ cd stainless
$ git checkout vscode
$ sbt
$ > publishLocal
$ > exit
$ cd .. # you should now be inside "project" folder

Update the path to Stainless used by the language server :

$ nano dotty/compiler/src/dotty/tools/dotc/interactive/InteractiveDriver.scala

Inside the run() function, update the basePath value from :
'' val basePath = "/home/florian/Desktop/EPFL/Master/sav/project/stainless/"
to :

'' val basePath = "/absolute/path/to/your/cloned/stainless"

Publish the local version of the language server :
$ cd dotty/
$ sbt
$ > publishLocal

Install vsce in order to publish the vscode extension

$ sudo npm -g install vsce 
$ cd dotty/vscode-dotty
$ vsce package

Clone and checkout the example project:

$ git clone https://github.com/flonso/dotty-example-project
$ cd dotty-example-project
$ git checkout vscode
$ sbt configureIDE
$ echo "ch.epfl.lamp:dotty-language-server_2.11:0.2.0-bin-SNAPSHOT-nonbootstrapped" > .dotty-ide-artifact

Finally launch VS Code by loading the extension :

$ cd dotty-example-project
$ code --extensionDevelopmentPath=$PWD/../dotty/vscode-dotty .