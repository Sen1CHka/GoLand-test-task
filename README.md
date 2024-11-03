- Indexes all `.txt` files in the specified directory.
- Checks for previously indexed files to avoid re-indexing.
- Simple command line interface for user interaction.
- All of available commands is in commands\commands.txt
- To start program run FileIndexerApp main()


Examples of commands : 
file recources\test1.txt 
  output : Indexed file: resources\test1.txt
dir recources
  output : resources\test1.txtis already indexed
           Indexed file: resources\test2.txt
           Indexed file: resources\test3.txt
word java
  output : Files contain word: java
           [resources\test1.txt, resources\test2.txt, resources\test3.txt]
allDir resources
  output : Indexed file: resources\dir1\dir11\test111.txt
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
word java
  output : Files contain word: java
           [resources\test1.txt, resources\dir1\test12.txt, resources\test2.txt, resources\test3.txt, resources\dir1\dir11\test111.txt, resources\dir1\dir11\test112.txt, resources\dir1\test11.txt, resources\dir2\test21.txt]
exit
