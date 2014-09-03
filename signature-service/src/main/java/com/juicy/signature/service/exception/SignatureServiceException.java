package com.juicy.signature.service.exception;

public class SignatureServiceException
    extends Exception
{
    private static final long serialVersionUID = 949282286716874926L;

    public SignatureServiceException( String message )
    {
        super( message );
    }

    public SignatureServiceException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
