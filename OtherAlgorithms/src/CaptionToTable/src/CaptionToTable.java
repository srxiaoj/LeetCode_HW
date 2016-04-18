package CaptionToTable.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CaptionToTable {
    private StringBuilder timeLine;
    private StringBuilder nameTag;
    private StringBuilder script;
    private StringBuilder index;
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static void main(String[] args) {
        CaptionToTable ob = new CaptionToTable();
        String fileName = "Captions.txt";
        ob.readCaption(fileName);
        ob.writeExcel("ind.txt", "nameTag.txt", "timeLine.txt", "script.txt");
    }
    private void writeExcel(String indexFile, String nameTagFile, String timeLineFile, String scriptFile) {
        FileWriter indFw = null;
        FileWriter nameTagFw = null;
        FileWriter timeLineFw = null;
        FileWriter scriptFw = null;
        try {
            indFw = new FileWriter(indexFile);
            nameTagFw = new FileWriter(nameTagFile);
            timeLineFw = new FileWriter(timeLineFile);
            scriptFw = new FileWriter(scriptFile);
            indFw.append(index);
            nameTagFw.append(nameTag);
            timeLineFw.append(timeLine);
            scriptFw.append(script);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AssertionError();
        } finally {
            try {
                indFw.flush();
                indFw.close();
                nameTagFw.flush();
                nameTagFw.close();
                timeLineFw.flush();
                timeLineFw.close();
                scriptFw.flush();
                scriptFw.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new AssertionError();
            }
        }
    }
    /**
     * read the file, and get the timeline, nameTag and script.
     * @param fileName file name
     */
    private void readCaption(String fileName) {
        timeLine = new StringBuilder("");
        nameTag = new StringBuilder("");
        script = new StringBuilder("");
        index = new StringBuilder("");
        int ind = 1;
        BufferedReader br = null;
        try {
            String line = "";
            String timeTemp = "";
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                if (line.contains("-->")) {
                    index.append(String.valueOf(ind));
                    index.append(NEW_LINE_SEPARATOR);
                    int startArrow = line.indexOf(",");
                    timeLine.append(line.substring(0, startArrow)); // get only the min and sec time line
                    timeLine.append(NEW_LINE_SEPARATOR);
                    timeTemp = line.substring(0, startArrow);
                    ind++;
                    line = br.readLine();
                    if (!line.contains("[")) {
                        int len = index.length();
                        int lengDel = String.valueOf(ind).length();
                        int len2 = timeLine.length();
                        int lengDel2 = timeTemp.length();
                        index.delete(len-lengDel-1, len);
                        timeLine.delete(len2-lengDel2-1, len2);
                        ind--;
                    }
                    while (line.contains("[")) {
                        int startTag = line.indexOf('[');
                        int endTag = line.indexOf(']');
                        nameTag.append(line.substring(startTag+1, endTag));
                        nameTag.append(NEW_LINE_SEPARATOR);
                        line = line.substring(endTag+1);
                        int nextTag = line.indexOf('[');
                        if (nextTag >= 0) {
                            script.append(line.substring(0, nextTag));
                            script.append(NEW_LINE_SEPARATOR);
                            timeLine.append(timeTemp);
                            timeLine.append(NEW_LINE_SEPARATOR);                        
                            index.append(String.valueOf(ind));
                            index.append(NEW_LINE_SEPARATOR);
                            ind++;
                        } else {
                            script.append(line);
                            script.append(NEW_LINE_SEPARATOR);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new AssertionError();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Error while closing file");
                throw new AssertionError();
            }
        }
        System.out.println(index.toString());
        System.out.println(timeLine.toString());
        System.out.println(nameTag.toString());
        System.out.println(script.toString());
    }
}
