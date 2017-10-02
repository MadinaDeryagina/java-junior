package com.acme.edu;


public class LoggerController {

    private Message prevMessage;
    private Saver saver;

    public LoggerController(Saver saver){
        this.saver = saver;
        prevMessage = null;
    }

    public void setCurrentMessage(Message current) {
        if( current == null) throw new NullPointerException("Invalid message");
        if( prevMessage != null) {
            if ( !prevMessage.equalsTypes(current)) {

                saver.save( prevMessage.formateForSave() );


            } else {
                if (prevMessage instanceof CountingPrimitiveMessage ) {

                    long prevSum = ((CountingPrimitiveMessage) prevMessage).getSum();
                    ((CountingPrimitiveMessage) current).addPrevSum(prevSum);

                } else if ( prevMessage instanceof MessageString ) {

                    if( ! ((MessageString) prevMessage).equalsString((MessageString) current) ){
                        saver.save( prevMessage.formateForSave() );
                    }else{
                        int prevCounter = ((MessageString) prevMessage).getCounter();
                        ((MessageString)current).setCountRepeated( prevCounter );
                    }

                } else {
                    saver.save( prevMessage.formateForSave() );

                }

            }
        }

         prevMessage = current;
    }
    public void close(){
        saver.save(prevMessage.formateForSave());
    }
}
