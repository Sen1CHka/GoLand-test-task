# Description
- Indexes all `.txt` files in the specified directory.
- Checks for previously indexed files to avoid re-indexing.
- Simple command line interface for user interaction.
- All of available commands is in commands\commands.txt
- To start program run FileIndexerApp main()

## Example

```cmd
File Indexer App
List of commands :
 - file <filePath> <word> : index file and return true if file contains word
 - file <filePath> : index file
 - dir <dirPath> <word> : index all files in current directory return set of files which contains word
 - dir <dirPath> : index all files in current directory
 - allDir <dirPath> <word> : index recursively all directories and files in current directory and return set of files which contains word
 - allDir <dirPath> : index recursively all directories and files in current directory
 - word <word> : return all previous files containing word
 - exit : exit the program
 - commands : print commands
Enter command : 
file resources\test1.txt
Indexed file: resources\test1.txt
Enter command : 
dir resources
resources\test1.txtis already indexed
Indexed file: resources\test2.txt
Indexed file: resources\test3.txt
Enter command : 
word java
Files contain word: java
[resources\test1.txt, resources\test2.txt, resources\test3.txt]
Enter command : 
allDir resources
Indexed file: resources\dir1\dir11\test111.txt
Indexed file: resources\dir1\dir11\test111.txt
Indexed file: resources\dir1\dir11\test112.txt
Indexed file: resources\dir1\dir11\test112.txt
Indexed file: resources\dir1\test11.txt
Indexed file: resources\dir1\test11.txt
Indexed file: resources\dir1\test12.txt
Indexed file: resources\dir1\test12.txt
Indexed file: resources\dir2\test21.txt
Indexed file: resources\dir2\test21.txt
resources\test1.txtis already indexed
resources\test2.txtis already indexed
resources\test3.txtis already indexed
Enter command : 
word java
Files contain word: java
[resources\test1.txt, resources\dir1\test12.txt, resources\test2.txt, resources\test3.txt, resources\dir1\dir11\test111.txt, resources\dir1\dir11\test112.txt, resources\dir1\test11.txt, resources\dir2\test21.txt]
Enter command : 
exit
```
