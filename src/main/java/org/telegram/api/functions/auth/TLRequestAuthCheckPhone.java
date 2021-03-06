package org.telegram.api.functions.auth;

import org.telegram.api.auth.TLCheckedPhone;
import org.telegram.tl.StreamingUtils;
import org.telegram.tl.TLContext;
import org.telegram.tl.TLMethod;
import org.telegram.tl.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The type TL request auth check phone.
 */
public class TLRequestAuthCheckPhone extends TLMethod<TLCheckedPhone> {
    /**
     * The constant CLASS_ID.
     */
    public static final int CLASS_ID = 0x6fe51dfb;

    private String phoneNumber;

    /**
     * Instantiates a new TL request auth check phone.
     */
    public TLRequestAuthCheckPhone() {
        super();
    }

    public int getClassId() {
        return CLASS_ID;
    }

    public TLCheckedPhone deserializeResponse(InputStream stream, TLContext context)
            throws IOException {
        TLObject res = StreamingUtils.readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if ((res instanceof TLCheckedPhone)) {
            return (TLCheckedPhone) res;
        }
        throw new IOException("Incorrect response type. Expected org.telegram.api.auth.TLCheckedPhone, got: " + res.getClass().getCanonicalName());
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param value the value
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public void serializeBody(OutputStream stream)
            throws IOException {
        StreamingUtils.writeTLString(this.phoneNumber, stream);
    }

    public void deserializeBody(InputStream stream, TLContext context)
            throws IOException {
        this.phoneNumber = StreamingUtils.readTLString(stream);
    }

    public String toString() {
        return "auth.checkPhone#6fe51dfb";
    }
}