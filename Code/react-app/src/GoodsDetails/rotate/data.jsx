import React from 'react';

 class GlobleData{
    constructor(){
        this.text = "xiaofeng";
    }
    getText=()=>{
        return this.text;
    }
    setText=(text)=>{
        this.text = text;
    }
}
export default(new GlobleData);