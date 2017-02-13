import java.io.*;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by Harman on 6/7/16.
 */


public class Parser
{
    public boolean DEBUG = false;
    public Vector<String> parsedLines;
    public String culture, generation, aLine,fileName;
    private boolean reached_RA = false;
    public ArrayList<String> urlLine = new ArrayList<String>();
    public boolean printToFile = false, csv;
    Scanner keyboard = new Scanner(System.in);

    /**
     * Default constructor that has two steps:
     * 1. gets the values to that will be used to determine the url for getting the data.
     * 2. Run the parser on the data and print it to either
     */
    public Parser()
    {
        getUserValues();
        run();
    }

    /**
     * @param val A separate constructor to allow for quick testing.
     */
    public Parser(String val)
    {
        if (val.equals("kim is best"))
        {
            predeterminedVals();
        }
    }

    /**
     * Private method that is used for testing.
     */
    private void predeterminedVals()
    {
        printToFile=true;
        fileName="all";
        culture = "HA3";
        generation="0";
        int on =0;
        while (true)
        {
            on++;
            System.out.print("Would you like to parse culture ["+culture+"] and generation ["+generation+"]? (yes/no)" +
                    " ");
            String next = keyboard.next();
            if(next.charAt(0)=='n'||next.charAt(0)=='N')
            {
                System.out.println("Would you like to stop the parsing?(yes/no)");
                if(keyboard.next().charAt(0)=='y'||(keyboard.next().charAt(0)=='Y'))
                    {break;}
            }
            else
            {run();}
            culture = getNextCulture(culture,generation);
            generation = getNextGeneration(culture,generation);
        }

    }

    /**
     * This method is used determine the correct mutation.
     * @param culture the culture of the generation
     * @param generation the generation
     * @return number of mutation
     */
    private String getNextGeneration(String culture, String generation)
    {
        int gen = Integer.parseInt(generation);
        switch (culture)
        {
            case "HS3":
            case "UA3":
            case "UR1":
            case "US1":
            case "HA3":
            {
                switch (gen)
                {
                    case 0:
                        return "300";
                    case 300:
                        return "500";
                    case 500:
                        return "780";
                    case 780:
                        return "1000";
                    case 1000:
                        return "0";
                }
            }
            case "HE3":
            case "UE3":
            case "HR2":
            {
                switch (gen)
                {
                    case 0:
                        return "300";
                    case 300:
                        return "500";
                    case 500:
                        return "780";
                    case 780:
                        return "0";
                    case 1000:
                        return "0";
                }
            }
            default:
                System.out.println("INVALID: "+culture + " " + generation);
                System.exit(-1);
        }return "";
    }

    /**
     * Get the next culture.
     * @param culture the culture that user is looking for.
     * @param generation the generation the user is looking for or the next generation the program is looking for.
     * @return returns the mutations group.
     */
    private String getNextCulture(String culture, String generation)
    {
        int gen = Integer.parseInt(generation);
        switch (gen)
        {
            case 0:
            case 300:
            case 500:
                return culture;
            case 780:
            {
                switch (culture)
                {
                    case "HA3":
                        return culture;
                    case "HE3":
                        return "HR2";
                    case "HR2":
                        return "HS3";
                    case "HS3":
                        return culture;
                    case "UA3":
                        return culture;
                    case "UE3":
                        return "UR1";
                    case "UR1":
                        return culture;
                    case "US1":
                        return culture;
                    default:
                        return culture;
                }
            }
            case 1000:
            {
                switch (culture)
                {
                    case "HA3":
                        return "HE3";
                    case "HE3":
                        return "HR2";
                    case "HR2":
                        return "HS3";
                    case "HS3":
                        return "UA3";
                    case "UA3":
                        return "UE3";
                    case "UE3":
                        return "UR1";
                    case "UR1":
                        return "US1";
                    case "US1":
                        return "HA3";
                    default:
                        return culture;
                }
            }
        }
        return "";
    }

    /**
     * Parses the file and records accordingly to the parameter. If CSV = true, then parse the file into a CSV.
     * @param csv boolean that determines if the parse end point should be a cvs or not.
     */
    private void parse(boolean csv)
    {
        parsedLines = new Vector<String>();
        if(urlLine != null)
        {
            int i =0;
            while(!reached_RA)
            {
                aLine = urlLine.get(i++);
                if(aLine.charAt(0) != '#')
                {
                    //split the line into tabs.
                    String[] splitTab = aLine.split("\t");
                    if(splitTab[0].equals("RA"))
                    {
                        reached_RA=true;
                    }
                    if(!splitTab[0].equals("MOB") && !splitTab[0].equals("SUB") && !splitTab[0].equals("RA"))
                    {
                        Evidence a = new Evidence(culture,generation);
                        if(splitTab[0].contains(","))
                        {
                            splitTab[0] = splitTab[0].replace(",", " | ");
                        }
                        if(splitTab[1].contains(","))
                        {
                            splitTab[1] = splitTab[1].replace(",", " | ");
                        }
                        if(splitTab[2].contains(","))
                        {
                            splitTab[2] = splitTab[2].replace(",", " | ");
                        }
                        if(splitTab[3].contains(","))
                        {
                            splitTab[3] = splitTab[3].replace(",", " | ");
                        }
                        if(splitTab[4].contains(","))
                        {
                            splitTab[4] = splitTab[4].replace(",", " | ");
                        }
                        if(splitTab[5].contains(","))
                        {
                            splitTab[5] = splitTab[5].replace(",", " | ");
                        }
                        a.setMutation(splitTab[0]);
                        a.setIndex(splitTab[1]);
                        a.setLineRef(splitTab[2]);
                        a.setRefSeqNumber(splitTab[3]);
                        a.setPosition(splitTab[4]);
                        a.setBase(splitTab[5]);
                        //after this everything has an equal size
                        for (int j = 0; j < splitTab.length; j++)
                        {
                            if (splitTab[j].contains("="))
                            {
                                String[] splitEqual = splitTab[j].split("=");
                                String identifer = splitEqual[0];
                                if(splitEqual[1].contains(","))
                                {
                                    splitEqual[1] = splitEqual[1].replace(",", " | ");
                                }
                                String value = splitEqual[1];
                                a.setValueByID(identifer, value);
                            }
                        }
                        if(csv)
                        {
                            parsedLines.addElement(a.getSQLInsert());
                        }
                        else
                        {
                            parsedLines.addElement(a.toString());
                        }
                    }
                }
            }
        }
    }

    /**
     * Writes to the file.
     * @param fileName name of the file.
     * @return if it successfully wrote to the file, then it returns true.
     */
    private boolean storeToFile(String fileName)
    {

        try {
            String content = "";

            File file = new File(fileName +".sql");
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();

            }
            for(int i =0;i<parsedLines.size();i++)
            {
                content += (parsedLines.elementAt(i) + "\n");
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Prints parsedLines.
     */
    private void print()
    {
        for(int i =0;i<parsedLines.size();i++)
        {
            System.out.println(parsedLines.elementAt(i) + "\n");
        }
    }

    /**
     * Sort of like a init()
     * Helps with organization and overhead of the file.
     */
    public void run()
    {
        Scanner keyboard = new Scanner(System.in);
        String next;
        do
        {
            parsedLines = null;
            reached_RA=false;
            aLine="";

            //connectToDB();
            connect();
            parse(csv);
            outPut();
            System.out.println("\n\t\tParsed!\n");
            System.out.print("Would you like to parse another gd file? (Yes/No) ");
            next = keyboard.next();
        }while (next.charAt(0) =='Y' || next.charAt(0) == 'y');
    }

    /**
     * If printToFile is true, then it stores to file instead of outputting to the console.
     */
    private void outPut()
    {
        if(printToFile)
        {
            storeToFile(fileName);
        }
        else
        {
            print();
        }
    }

    /**
     * Used to make a HTTP connection to the URL after parsing.
     * @return if a successful connection has been made.
     */
    private boolean connect() {
        URL url;
        String aURL = "";
        InputStream is = null;
        String line;
        boolean retval = false;

        // Install Authenticator
        // CHANGE PASSWORD
        MyAuthenticator.setPasswordAuthentication("wkim", "FAKE PASSWORD");
        Authenticator.setDefault (new MyAuthenticator ());
        //CHOSE WHICH FILE TO PARSE:
        if(generation.equals("0"))
        {
            aURL ="http://wkim-ubuntu.css.uwb.edu/BreseqOutput/Ancestor/output/evidence/annotated.gd";
            culture = "Ancestor";
        }
        else
        {
            aURL = "http://wkim-ubuntu.css.uwb.edu/BreseqOutput/"+culture+"/" + generation +
                    "/output/evidence/annotated.gd";
        }
        try {
            url = new URL(aURL);
            is = url.openStream();  // throws an IOException
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(is));
            urlLine = new ArrayList<String>();
            while ((line = br.readLine()) != null)
            {
                urlLine.add(line);
            }
            retval=true;
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return retval;
    }

    /**
     *  Used to determine culture, generation, and out put to csv or sql.
     */
    public void getUserValues()
    {
        System.out.print("Enter culture\n(HA3 / HE3 / HR2 / HS3 / UA3 / UE3 / UR1 / US1): ");
        culture = keyboard.next();
        culture = culture.toUpperCase();

        System.out.print("Enter which generation file you would like to parse\n( 300 / 500 / 780 / 1000): ");
        generation = keyboard.next();
        String a,b;
        if(DEBUG)
        {
            a = "file";b = "csv";
        }
        else
        {
            System.out.print("Would you like to save the parsed data to a file or the console. (File/Console) ");
            a = keyboard.next();
            if(a.charAt(0) =='f' ||a.charAt(0) =='F')
            {
                printToFile = true;
                System.out.print("Enter the filename: ");
                fileName = keyboard.next();
            }
            System.out.print("Format for the output. (SQL Insert statements/ String line) ");
            b = keyboard.next();
        }
        if(b.charAt(0)=='S' ||b.charAt(0) =='s' ||b.charAt(0) =='I'||b.charAt(0) =='i')
        {
            csv=true;
        }
        else
        {
            csv=false;
        }
    }
}
