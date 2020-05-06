package datawave.webservice.query.map;

import org.apache.commons.lang.StringEscapeUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * This represents a datawave geo function and the associated query geometry in GeoJSON format.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class QueryGeometry implements Serializable {
    
    @XmlElement
    private String function;
    @XmlElement
    private String geometry;
    
    public QueryGeometry(String function, String geometry) {
        this.function = function;
        this.geometry = geometry;
    }
    
    public String getFunction() {
        return function;
    }
    
    public void setFunction(String function) {
        this.function = function;
    }
    
    public String getGeometry() {
        return geometry;
    }
    
    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }
    
    public String toGeoJsonFeature() {
        return "{'type': 'Feature', 'properties': {'function': \"" + StringEscapeUtils.escapeHtml(function) + "\"},'geometry': " + geometry + "}";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof QueryGeometry))
            return false;
        
        QueryGeometry that = (QueryGeometry) o;
        
        if (function != null ? !function.equals(that.function) : that.function != null)
            return false;
        return geometry != null ? geometry.equals(that.geometry) : that.geometry == null;
    }
    
    @Override
    public int hashCode() {
        int result = function != null ? function.hashCode() : 0;
        result = 31 * result + (geometry != null ? geometry.hashCode() : 0);
        return result;
    }
}
