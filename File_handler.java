package fr.Alain.objoinformer;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class File_handler
{

    public File_handler()
    {

    }

    public String File_Reading(Context context,String FileName)
    {
        String line = new String();


        try {
            //Récupération du fichier depuis les assets
            InputStream inputStream = context.getAssets().open(FileName);
            InputStreamReader isr = new InputStreamReader(inputStream,StandardCharsets.ISO_8859_1);
            BufferedReader reader = new BufferedReader(isr);

            String str;
            while ((str = reader.readLine()) != null)
            {

                line += str;
            }

            reader.close();
            isr.close();
            inputStream.close();

        } catch (IOException e)
        {
            e.printStackTrace();
        }


        return line;
    }

}