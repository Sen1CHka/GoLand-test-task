- Indexes all `.txt` files in the specified directory.
- Checks for previously indexed files to avoid re-indexing.
- Simple command line interface for user interaction.
- All of available commands is in commands\commands.txt
- To start program run FileIndexerApp main()


Examples of commands : <br>
file recources\test1.txt <br>
  output : Indexed file: resources\test1.txt<br>
dir recources<br>
  output : resources\test1.txtis already indexed<br>
           Indexed file: resources\test2.txt<br>
           Indexed file: resources\test3.txt<br>
word java<br>
  output : Files contain word: java<br>
           [resources\test1.txt, resources\test2.txt, resources\test3.txt]<br>
allDir resources<br>
  output : Indexed file: resources\dir1\dir11\test111.txt<br>
           Indexed file: resources\dir1\dir11\test111.txt<br>
           Indexed file: resources\dir1\dir11\test112.txt<br>
           Indexed file: resources\dir1\dir11\test112.txt<br>
           Indexed file: resources\dir1\test11.txt<br>
           Indexed file: resources\dir1\test11.txt<br>
           Indexed file: resources\dir1\test12.txt<br>
           Indexed file: resources\dir1\test12.txt<br>
           Indexed file: resources\dir2\test21.txt<br>
           Indexed file: resources\dir2\test21.txt<br>
           resources\test1.txtis already indexed<br>
           resources\test2.txtis already indexed<br>
           resources\test3.txtis already indexed<br>
word java<br>
  output : Files contain word: java<br>
           [resources\test1.txt, resources\dir1\test12.txt, resources\test2.txt, resources\test3.txt, resources\dir1\dir11\test111.txt, resources\dir1\dir11\test112.txt, resources\dir1\test11.txt, resources\dir2\test21.txt]<br>
exit<br>
