import React from 'react';
import FirstBottom from './FirstBottom';
import FirstBottom1 from './FirstBottom1';
const FirstA  = props =>{
    return(
            <div>
                <FirstBottom name={props.name} />
                <FirstBottom1 name1={props.name1}/>
            </div>
    );
  }
export default FirstA ;