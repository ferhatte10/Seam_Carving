
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SeamCarving{

    public static void main(String[] args) throws Exception {
        String output_file = "Resized_pucture_" ;
        String input_file = null;
        int output_width ;
        int output_height ;
	      String origin_name ;
        try {


           input_file = args[0]; //extraction du premier param de la ligne de commande unix
	         origin_name = input_file.substring(0,(input_file.length() - 4)) ;
	         File Original1 = new File( input_file); // seulement pour pouvoir recuper la taille de l'image  (pour avoir acces a la methode getWidth et getHeight)
	         BufferedImage original = ImageIO.read(Original1); // same as up
           output_width = (Integer.parseInt(args[1])* original.getWidth())/100 ;
           output_height =(Integer.parseInt(args[2])* original.getHeight())/100 ;
	         output_file = origin_name +"_pucture_resized_" ;

        } catch(Exception e)
        {
            System.out.println("Usage: 'java SeamCarver [input file]  [output width %] [output height %]");
            System.out.println(e);
            return;
        }


        File pngOriginal = new File(input_file); //on charge l'image original du dossier image
        File pngResized = new File(output_file + output_width +"x"+ output_height +"( "+ args[1] +"% "+ args[2]+"% "+")"+ ".jpg"); //on crée temp la nouvelle image avec le nom demandé
        resizeImage(pngOriginal,pngResized,output_width,output_height, "jpg"); // appel a la methode resizeImage pour traiter l'image
        System.out.println("/50e/Pictures_test/" + input_file);

    }

    private static void resizeImage(File originalImage, File resisezImage, int width , int height, String format ){
        try{//on fait des exeption pour pouvoir ou on se trompe en codant le programme

            BufferedImage original = ImageIO.read(originalImage); // On crée un BufferedImage avec une instance de ImageIO pour pouvoir lire l'image
            BufferedImage resized = new BufferedImage(width,height,original.getType()); // la on mit a jour les nouveau param de l'image (width & height)
            Graphics2D g2 = resized.createGraphics(); //avec Graphics2D on vas pouvoir redissiner l'image dans le nouveau fichier crée
            g2.drawImage(original,0,0,width,height,null); // suite de ligne 44
            g2.dispose();                                 // pareil
            ImageIO.write(resized,format,resisezImage);   // on ecrit les donné dans le nv fichier image (le 50% restant du ligne 44)


        }
        catch (IOException e){
            e.printStackTrace();
        }



    }

    }
