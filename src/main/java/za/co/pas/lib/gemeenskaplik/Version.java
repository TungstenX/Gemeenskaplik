/**
 *
 */
package za.co.pas.lib.gemeenskaplik;

import java.util.Objects;

/**
 *
 * @author Andre Labuschagne
 */
public class Version implements Comparable<Version> {

    private String version;

    public final String get() {
        return this.version;
    }

    /**
     * 
     * @param version
     * @throws IllegalArgumentException as version nul is of nie reg is nie
     */
    public Version(String version) throws IllegalArgumentException {
        if (version == null) {
            throw new IllegalArgumentException("Version can not be null");
        }
        if (!version.matches("\\d+(\\.\\d+)*")) {
            throw new IllegalArgumentException("Invalid version format: " + version);
        }
        this.version = version;
    }

    @Override
    public int compareTo(Version that) {
        if (that == null) {
            return 1;
        }
        String[] thisParts = this.get().split("\\.");
        String[] thatParts = that.get().split("\\.");
        int length = Math.max(thisParts.length, thatParts.length);
        for (int i = 0; i < length; i++) {
            int thisPart = i < thisParts.length
                    ? Integer.parseInt(thisParts[i]) : 0;
            int thatPart = i < thatParts.length
                    ? Integer.parseInt(thatParts[i]) : 0;
            if (thisPart < thatPart) {
                return -1;
            }
            if (thisPart > thatPart) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (this.getClass() != that.getClass()) {
            return false;
        }
        return this.compareTo((Version) that) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.version);
        return hash;
    }

}
