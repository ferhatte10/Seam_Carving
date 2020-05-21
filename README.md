# Seam-Carving
A Java implementation of Seam Carving, which is an algorithm for content aware image resizing.

## How to use

Take the src folder and place it in a directory where the image you want to resize is. Then open up the console/terminal navigate to the folder then compile the .java files:

```
javac -d out src/com/ferhat/SeamCarving.java
```

This will create a folder called out which will keep the compiled .class files. Then to run the program run this command:

```
java -cp ./out SeamCarving [input image]  [width %] [height %]
```
For example the following command will take the file "input.jpg" carve it down to 500x500 (1000x1000 the original size) and save it to "input_picture_resized_500x500(50% 50%).jpg":

```
java -cp ./out SeamCarving input.jpg  50 50
```

## Example

### Test Input (3840x2160)
![Test input](./test/cat.jpg)

### Test Output (768x1080)
![Test output](./test/cat_pucture_resized_768x1080( 20% 50% ).jpg)

### Test Output (1920x432)
![Test output](./test/cat_pucture_resized_1920x432( 50% 20% ).jpg)
