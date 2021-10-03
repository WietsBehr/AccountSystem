package za.ac.nwu.domain.service;

//import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<e> implements Serializable {

//    @Serial
    private static final long serialVersionUID = -4424297116985829976L;
    private final boolean successful;
    private final transient e payload;

    public GeneralResponse(boolean successful, e payload)
    {
        this.successful = successful;
        this.payload = payload;
    }

    public boolean isSuccessful() {return successful;}

    public e getPayload() {return payload;}

    @Override
    public boolean equals(Object p)
    {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        GeneralResponse<?> that = (GeneralResponse<?>) p;
        return successful == that.successful && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {return Objects.hash(successful,payload);}

    @Override
    public String toString()
    {
        return "GeneralResponse{" + "successful="  + successful + ", payload=" + payload + '}';
    }
}
