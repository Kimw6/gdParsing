/**
 * Created by Harman on 4/17/16.
 */

import javax.xml.crypto.Data;
import java.math.BigDecimal;

public class DataLine
{
    private String mutation =null;
    private  int index = -1;
    private int lineRef = -1;
    private String seqReference = "";
    private int position = -1;
    private String first;
    private char second;
    private char third;
    private int bias_e_value = -1;
    private double bias_p_value = -1;
    private double consensus_score = -1;
    private double fisher_strand_p_value = -1;
    private double frequency = -1;                  //need to convert the freq into a regular number
    private double ks_quality_p_value =1;
    private double log10_qual_likelihood_position_model =1;
    private double log10_strand_likelihood_position_model =-1;
    private int major_binomial_strand_lower_bound =-1;
    private String new_cov = "";
    private double polymorphism_frequency=-1;       //need to convert the e
    private double polymorphism_score = -1;         // also can be N/A
    private String prediction = "";
    private String ref_cov = "";
    private String reject = "";
    private double score =-1;
    private String tot_cov = "";

    @Override
    public String toString()
    {
        return "DataLine{" +
                "mutation='" + mutation + '\'' +
                ", index=" + index +
                ", lineRef=" + lineRef +
                ", seqReference='" + seqReference + '\'' +
                ", position=" + position +
                ", first=" + first +
                ", second=" + second +
                ", third=" + third +
                ", bias_e_value=" + bias_e_value +
                ", bias_p_value=" + bias_p_value +
                ", consensus_score=" + consensus_score +
                ", fisher_strand_p_value=" + fisher_strand_p_value +
                ", frequency=" + frequency +
                ", ks_quality_p_value=" + ks_quality_p_value +
                ", log10_qual_likelihood_position_model=" + log10_qual_likelihood_position_model +
                ", log10_strand_likelihood_position_model=" + log10_strand_likelihood_position_model +
                ", major_binomial_strand_lower_bound=" + major_binomial_strand_lower_bound +
                ", new_cov='" + new_cov + '\'' +
                ", polymorphism_frequency=" + polymorphism_frequency +
                ", polymorphism_score=" + polymorphism_score +
                ", prediction='" + prediction + '\'' +
                ", ref_cov='" + ref_cov + '\'' +
                ", reject='" + reject + '\'' +
                ", score=" + score +
                ", tot_cov='" + tot_cov + '\'' +
                '}';
    }

    public DataLine()
    {}


    public DataLine(String index, String aline, String mutation, String seqReference, String position, String first,
                    String
            second,
                    String third, String bias_e_value, String bias_p_value, String consensus_score,
                    String fisher_strand_p_value, String frequency, String ks_quality_p_value,
                    String log10_qual_likelihood_position_model, String log10_strand_likelihood_position_model,
                    String major_binomial_strand_lower_bound, String new_cov, String polymorphism_frequency,
                    String polymorphism_score, String prediction, String ref_cov, String reject,
                    String score, String tot_cov)
    {
        this.index = StringToInt(index);
        this.lineRef = StringToInt(aline);
        this.mutation = setString(mutation);
        this.seqReference = setString(seqReference);
        this.position = StringToInt(position);
        this.first = (first);
        this.second = StringToChar(second);
        this.third = StringToChar(third);
        this.bias_e_value = StringToInt(bias_e_value);
        this.bias_p_value = StringToInt(bias_p_value);
        this.consensus_score = StringToDouble(consensus_score);
        this.fisher_strand_p_value = StringToDouble(fisher_strand_p_value);
        this.frequency = StringToDouble(frequency);
        this.ks_quality_p_value = StringToDouble(ks_quality_p_value);
        this.log10_qual_likelihood_position_model = StringToDouble(log10_qual_likelihood_position_model);
        this.log10_strand_likelihood_position_model = StringToDouble(log10_strand_likelihood_position_model);
        this.major_binomial_strand_lower_bound = StringToInt(major_binomial_strand_lower_bound);
        this.new_cov = setString(new_cov);
        this.polymorphism_frequency = StringToDouble(polymorphism_frequency);
        this.polymorphism_score = StringToDouble(polymorphism_score);
        this.prediction = setString(prediction);
        this.ref_cov = setString(ref_cov);
        this.reject = setString(reject);
        this.score = StringToDouble(score);
        this.tot_cov = setString(tot_cov);
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
            return 0;
        }
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


    public boolean setValueByID(String ID, String val)
    {
        switch (ID)
        {
            case "":
                return false;
            case "index":
            case "mutation":
            case "seqReference":
            case "position":
            case "first":
            case "second":
            case "third" :
            case "bias_e_value":
            case "bias_p_value":
            case "consensus_score":
            case "fisher_strand_p_value":
            case "frequency":
            case "ks_quality_p_value":
            case "log10_qual_likelihood_position_model":
            case "log10_strand_likelihood_position_model":
            case "major_binomial_strand_lower_bound":
            case "new_cov":
            case "polymorphism_frequency":
            case "polymorphism_score":
            case "prediction":
            case "ref_cov":
            case "reject":
            case "score":
            case "tot_cov":
        }

        return false;
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
        return index;
    }

    public int getLineRef() {return lineRef;}


    public String getSeqReference()
    {
        return seqReference;
    }

    public int getPosition()
    {
        return position;
    }

    public String getFirst()
    {
        return first;
    }

    public char getSecond()
    {
        return second;
    }

    public char getThird()
    {
        return third;
    }

    public int getBias_e_value()
    {
        return bias_e_value;
    }

    public double getBias_p_value()
    {
        return bias_p_value;
    }

    public double getConsensus_score()
    {
        return consensus_score;
    }

    public double getFisher_strand_p_value()
    {
        return fisher_strand_p_value;
    }

    public double getFrequency()
    {
        return frequency;
    }

    public double getKs_quality_p_value()
    {
        return ks_quality_p_value;
    }

    public double getLog10_qual_likelihood_position_model()
    {
        return log10_qual_likelihood_position_model;
    }

    public double getLog10_strand_likelihood_position_model()
    {
        return log10_strand_likelihood_position_model;
    }

    public int getMajor_binomial_strand_lower_bound()
    {
        return major_binomial_strand_lower_bound;
    }

    public String getNew_cov()
    {
        return new_cov;
    }

    public double getPolymorphism_frequency()
    {
        return polymorphism_frequency;
    }

    public double getPolymorphism_score()
    {
        return polymorphism_score;
    }

    public String getPrediction()
    {
        return prediction;
    }

    public String getRef_cov()
    {
        return ref_cov;
    }

    public String getReject()
    {
        return reject;
    }

    public double getScore()
    {
        return score;
    }

    public String getTot_cov()
    {
        return tot_cov;
    }

    /*------------------------------------------------------------------------------
    ================================SETTERS=========================================
    ------------------------------------------------------------------------------*/

    public void setMutation(String mutation)
    {
        this.mutation = setString(mutation);
    }

    public void setIndex(String index)
    {
        this.index = StringToInt(index);
    }

    public void setLineRef(String lineRef) {this.lineRef = StringToInt(lineRef);}

    public void setSeqReference(String seqReference) {this.seqReference = setString(seqReference);}

    public void setPosition(String position)
    {
        this.position = StringToInt(position);
    }

    public void setFirst(String first)
    {
        this.first = (first);
    }

    public void setSecond(String second)
    {
        this.second = StringToChar(second);
    }

    public void setThird(String third)
    {
        this.third = StringToChar(third);
    }

    public void setBias_e_value(String bias_e_value)
    {
        this.bias_e_value = StringToInt(bias_e_value);
    }

    public void setBias_p_value(String bias_p_value)
    {
        this.bias_p_value = StringToDouble(bias_p_value);
    }

    public void setConsensus_score(String consensus_score)
    {
        this.consensus_score = StringToDouble(consensus_score);
    }

    public void setFisher_strand_p_value(String fisher_strand_p_value)
    {
        this.fisher_strand_p_value = StringToDouble(fisher_strand_p_value);
    }

    public void setFrequency(String frequency)
    {
        this.frequency = StringToDouble(frequency);
    }

    public void setKs_quality_p_value(String ks_quality_p_value)
    {
        this.ks_quality_p_value = StringToDouble(ks_quality_p_value);
    }

    public void setLog10_qual_likelihood_position_model(String log10_qual_likelihood_position_model)
    {
        this.log10_qual_likelihood_position_model = StringToDouble(log10_qual_likelihood_position_model);
    }

    public void setLog10_strand_likelihood_position_model(String log10_strand_likelihood_position_model)
    {
        this.log10_strand_likelihood_position_model = StringToDouble(log10_strand_likelihood_position_model);
    }

    public void setMajor_binomial_strand_lower_bound(String major_binomial_strand_lower_bound)
    {
        this.major_binomial_strand_lower_bound = StringToInt(major_binomial_strand_lower_bound);
    }

    public void setNew_cov(String new_cov)
    {
        this.new_cov = new_cov;
    }

    public void setPolymorphism_frequency(String polymorphism_frequency)
    {
        this.polymorphism_frequency = StringToDouble(polymorphism_frequency);
    }

    public void setPolymorphism_score(String polymorphism_score)
    {
        this.polymorphism_score = StringToDouble(polymorphism_score);
    }

    public void setPrediction(String prediction)
    {
        this.prediction = prediction;
    }

    public void setRef_cov(String ref_cov)
    {
        this.ref_cov = ref_cov;
    }

    public void setReject(String reject)
    {
        this.reject = reject;
    }

    public void setScore(String score)
    {
        this.score = StringToDouble(score);
    }

    public void setTot_cov(String tot_cov)
    {
        this.tot_cov = tot_cov;
    }
}

