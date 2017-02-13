import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.math.BigDecimal;

/**
 * Created by Harman on 4/18/16.
 */
public class Evidence
{
    String culture, generation;
    String mutation = " ";
    int indexRef;
    //if no value then -1
    String lineRef= " ";
    String refSeqNumber= " ";
    int position=-1;
    String base= " ";
    char aa_new_seq ='-';
    int aa_position=-1;
    char aa_ref_seq='-';
    String codon_new_seq= " ";
    int codon_number=-1;
    int codon_position=-1;
    String codon_ref_seq= " ";
    double frequency=-1;
    String gene_list= " ";
    String gene_name= " ";
    String gene_position= " ";
    String gene_product= " ";
    char gene_strand='-';
    String html_gene_name= " ";
    String locus_tag= " ";
    String snp_type= " ";
    int transl_table=-1;

    public Evidence(){}
    public Evidence(String newCulture, String newGeneration)
    {
        culture=newCulture;
        generation = newGeneration;
    }

    public Evidence(String mutation, String index, String position, String refSeqNumber, String base,
                    String aa_new_seq, String aa_position, String aa_ref_seq, String codon_new_seq, String codon_number,
                    String codon_position, String codon_ref_seq, String frequency, String gene_list, String gene_name,
                    String gene_position, String gene_product, String gene_strand, String html_gene_name,
                    String locus_tag, String snp_type, String transl_table )
    {
        this.mutation = setString(mutation);
        this.indexRef = StringToInt(index);
        this.position = StringToInt(position);
        this.refSeqNumber = setString(refSeqNumber);
        this.base = (base);
        this.aa_new_seq = StringToChar(aa_new_seq);
        this.aa_position = StringToInt(aa_position);
        this.aa_ref_seq = StringToChar(aa_ref_seq);
        this.codon_new_seq = setString(codon_new_seq);
        this.codon_number = StringToInt(codon_number);
        this.codon_position = StringToInt(codon_position);
        this.codon_ref_seq = setString(codon_ref_seq);
        this.frequency = StringToDouble(frequency);
        this.gene_list = setString(gene_list);
        this.gene_name = setString(gene_name);
        this.gene_position = (gene_position);
        this.gene_product = (gene_product);
        this.gene_strand = StringToChar(gene_strand);
        this.html_gene_name = setString(html_gene_name);
        this.locus_tag = setString(locus_tag);
        this.snp_type = setString(snp_type);
        this.transl_table = StringToInt(transl_table);
    }

    private char StringToChar(String val)
    {
        if(val == null || val.equals(""))
        {
            return '/';
        }
        else
        {
            return val.charAt(0);
        }
    }

    private int StringToInt(String val)
    {
        if(val == null || val.equals(""))
        {
            return -1;
        }
        //System.out.println("\n \t This is val: ERROR:" + val +"\n");
        return Integer.parseInt(val);
    }

    private double StringToDouble(String val)
    {
        if (val == null || val.equals(""))
        {
            return -1;
        }
        else
        {
            return new BigDecimal(val).doubleValue();
        }
    }

    public String setString(String val)
    {
        if(val == null || val.equals(""))
        {
            return "";
        }
        else
        {
            return val;
        }
    }

    public boolean setMutation(String mutation)
    {
        this.mutation = mutation; return true;
    }

    public boolean setIndex(String  index) {this.indexRef = StringToInt(index);return true;}

    public void setLineRef(String lineRef)
    {
        this.lineRef = (lineRef);
    }



    public boolean setPosition(String  position)
    {
        this.position = StringToInt(position); return true;
    }

    public boolean setRefSeqNumber(String refSeqNumber)
    {
        this.refSeqNumber = refSeqNumber; return true;
    }

    public boolean setBase(String base)
    {
        this.base = base;return true;
    }

    public boolean setAa_new_seq(String aa_new_seq) {this.aa_new_seq = StringToChar(aa_new_seq);return true;}

    public boolean setAa_position(String aa_position)
    {this.aa_position = StringToInt(aa_position);return true;}

    public boolean setAa_ref_seq(String aa_ref_seq)
    {
        this.aa_ref_seq = StringToChar(aa_ref_seq);return true;
    }

    public boolean setCodon_new_seq(String codon_new_seq)
    {
        this.codon_new_seq = codon_new_seq;return true;
    }

    public boolean setCodon_number(String codon_number)
    {
        this.codon_number = StringToInt(codon_number);return true;
    }

    public boolean setCodon_position(String codon_position)
    {
        this.codon_position = StringToInt(codon_position);return true;
    }

    public boolean setCodon_ref_seq(String codon_ref_seq)
    {
        this.codon_ref_seq = codon_ref_seq;return true;
    }

    public boolean setFrequency(String frequency)
    {
        this.frequency = StringToDouble(frequency);return true;
    }

    public boolean setGene_list(String gene_list)
    {
        this.gene_list = gene_list;return true;
    }

    public boolean setGene_name(String gene_name)
    {
        this.gene_name = gene_name;return true;
    }

    public boolean setGene_position(String gene_position)
    {
        this.gene_position = (gene_position);return true;
    }

    public boolean setGene_product(String gene_product)
    {
        this.gene_product = (gene_product);return true;
    }

    public boolean setGene_strand(String gene_strand){this.gene_strand = StringToChar(gene_strand);return true;}

    public boolean setHtml_gene_name(String html_gene_name)
    {
        this.html_gene_name = html_gene_name;return true;
    }

    public boolean setLocus_tag(String locus_tag)
    {
        this.locus_tag = locus_tag;return true;
    }

    public boolean setSnp_type(String snp_type)
    {
        this.snp_type = snp_type;return true;
    }

    public boolean setTransl_table(String transl_table)
    {
        this.transl_table = StringToInt(transl_table);return true;
    }


    /*------------------------------------------------------------------------------
    ================================GETTERS=========================================
    ------------------------------------------------------------------------------*/

    public String getMutation()
    {
        return mutation;
    }

    public int getIndex()
    {
        return indexRef;
    }

    public String getLineRef()
    {
        return lineRef;
    }


    public int getPosition()
    {
        return position;
    }

    public String getRefSeqNumber()
    {
        return refSeqNumber;
    }

    public String getBase()
    {
        return base;
    }

    public char getAa_new_seq()
    {
        return aa_new_seq;
    }

    public int getAa_position()
    {
        return aa_position;
    }

    public char getAa_ref_seq()
    {
        return aa_ref_seq;
    }

    public String getCodon_new_seq()
    {
        return codon_new_seq;
    }

    public int getCodon_number()
    {
        return codon_number;
    }

    public int getCodon_position()
    {
        return codon_position;
    }

    public String getCodon_ref_seq()
    {
        return codon_ref_seq;
    }

    public double getFrequency()
    {
        return frequency;
    }

    public String getGene_list()
    {
        return gene_list;
    }

    public String getGene_name()
    {
        return gene_name;
    }

    public String getGene_position()
    {
        return gene_position;
    }

    public String getGene_product()
    {
        return gene_product;
    }

    public char getGene_strand(){return gene_strand;}

    public String getHtml_gene_name()
    {
        return html_gene_name;
    }

    public String getLocus_tag()
    {
        return locus_tag;
    }

    public String getSnp_type()
    {
        return snp_type;
    }

    public int getTransl_table()
    {
        return transl_table;
    }
    @Override
    public String toString()
    {
        return "Culture= "+ culture+
                ", Generation= "+ generation+
                ", Mutation= "+ mutation +
                ", index= " + indexRef +
                ", lineRef= " + lineRef +
                ", refSeqNumber= " + refSeqNumber +
                ", position= " + position +
                ", base= " + base +
                ", aa_new_seq=" + aa_new_seq +
                ", aa_position=" + aa_position +
                ", aa_ref_seq=" + aa_ref_seq +
                ", codon_new_seq=" + codon_new_seq +
                ", codon_number=" + codon_number +
                ", codon_position=" + codon_position +
                ", codon_ref_seq=" + codon_ref_seq +
                ", frequency=" + frequency +
                ", gene_list=" + gene_list +
                ", gene_name=" + gene_name +
                ", gene_position=" + gene_position +
                ", gene_product=" + gene_product +
                ", gene_strand=" + gene_strand +
                ", html_gene_name=" + html_gene_name +
                ", locus_tag=" + locus_tag +
                ", snp_type=" + snp_type +
                ", transl_table=" + transl_table;
    }

    public String toStringCSV()
    {
        return ""+ culture +
                ", " + generation +
                ", "+ mutation +
                ", " + indexRef +
                ", " + lineRef +
                ", " + refSeqNumber +
                ", " + position +
                ", " + base +
                ", " + aa_new_seq +
                ", " + aa_position +
                ", " + aa_ref_seq +
                ", " + codon_new_seq +
                ", " + codon_number +
                ", " + codon_position +
                ", " + codon_ref_seq +
                ", " + frequency +
                ", " + gene_list +
                ", " + gene_name +
                ", " + gene_position +
                ", " + gene_product +
                ", " + gene_strand +
                ", " + html_gene_name +
                ", " + locus_tag +
                ", " + snp_type +
                ", " + transl_table;
    }
    public String CSVHeader()
    {
        return "culture" +
                ", " + "generation" +
                ", " + "mutation" +
                ", " + "index" +
                ", " + "lineRef" +
                ", " + "refSeqNumber" +
                ", " + "position" +
                ", " + "base" +
                ", " + "aa_new_seq" +
                ", " + "aa_position" +
                ", " + "aa_ref_seq" +
                ", " + "codon_new_seq" +
                ", " + "codon_number" +
                ", " + "codon_position" +
                ", " + "codon_ref_seq" +
                ", " + "frequency" +
                ", " + "gene_list" +
                ", " + "gene_name" +
                ", " + "gene_position" +
                ", " + "gene_product" +
                ", " + "gene_strand" +
                ", " + "html_gene_name" +
                ", " + "locus_tag" +
                ", " + "snp_type" +
                ", " + "transl_table";
    }


    public String getSQLInsert()
    {return "INSERT INTO TEST_TABLE(culture,  generation,  mutation,  indexRef,  lineRef,  refSeqNumber,  position,  base,  " +
            "aa_new_seq,  aa_position,  aa_ref_seq,  codon_new_seq,  codon_number,  codon_position,  codon_ref_seq,  frequency,  " +
            "gene_list,  gene_name,  gene_position,  gene_product,  gene_strand,  html_gene_name,  locus_tag,  snp_type,  " +
            "transl_table) VALUES ("
                + "'"+culture+"', "+ generation+ ",' "+mutation+"', "+indexRef+ ", '"+lineRef+"', " +
                "'"+refSeqNumber+"', "+position+ ", '" +base + "', '"+aa_new_seq+"', "+aa_position + ", " +
            "'"+aa_ref_seq+ "', '" +codon_new_seq +"', "+codon_number+ ", " + codon_position+", '"+ codon_ref_seq+
            "', " + frequency+ ", '"+gene_list+"', '" + gene_name+"', '" + gene_position+"', '"+ gene_product+ "', " +
            ""+"'"+gene_strand+"', " + "'"+html_gene_name+"', " + "'"+locus_tag+"', "+"'"+snp_type+"', " +
            ""+transl_table+");";
    }
    public String getSQLCreateTable()
    {
        return "CREATE TABLE dbSequenced.TEST_TABLE2 (\n" +
                "   culture TEXT,\n" +
                "   generation INT,\n" +
                "   mutation TEXT,\n" +
                "   indexRef INT,\n" +
                "   lineRef TEXT,\n" +
                "   refSeqNumber TEXT,\n" +
                "   position INT,\n" +
                "   base TEXT,\n" +
                "   aa_new_seq TEXT,\n" +
                "   aa_position INT,\n" +
                "   aa_ref_seq TEXT,\n" +
                "   codon_new_seq TEXT,\n" +
                "   codon_number INT,\n" +
                "   codon_position INT,\n" +
                "   codon_ref_seq TEXT,\n" +
                "   frequency FLOAT,\n" +
                "   gene_list TEXT,\n" +
                "   gene_name TEXT,\n" +
                "   gene_position TEXT,\n" +
                "   gene_product TEXT,\n" +
                "   gene_strand TEXT,\n" +
                "   html_gene_name BLOB,\n" +
                "   locus_tag BLOB,\n" +
                "   snp_type TEXT,\n" +
                "   transl_table bigint\n" +
                ");";
    }


    public boolean setValueByID(String ID, String val)
    {
        switch (ID)
        {
            case "":
                return true;
            case "aa_new_seq":
                return setAa_new_seq(val);
            case "aa_position":
                return setAa_position(val);
            case "aa_ref_seq":
                return setAa_ref_seq(val);
            case "codon_new_seq":
                return setCodon_new_seq(val);
            case "codon_number":
                return setCodon_number(val);
            case "codon_position":
                return setCodon_position(val);
            case "codon_ref_seq":
                return setCodon_ref_seq(val);
            case "frequency" :
                return setFrequency(val);
            case "gene_list":
                return setGene_list(val);
            case "gene_name":
                return setGene_name(val);
            case "gene_position":
                return setGene_position(val);
            case "gene_product":
                return setGene_product(val);
            case "gene_strand":
                return setGene_strand(val);
            case "html_gene_name":
                return setHtml_gene_name(val);
            case "locus_tag":
                return setLocus_tag(val);
            case "snp_type":
                return setSnp_type(val);
            case "transl_table":
                return setTransl_table(val);
            default:
                return false;
        }
    }
}
