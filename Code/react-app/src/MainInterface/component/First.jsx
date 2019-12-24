import React from 'react';
import Top from './Top';
import TiTle from './title';
import Search from './Search';
import Hot from './Hot';
import Strip from './Strip';
import FirstMiddle from './FirstMiddle';

const First  = props =>{
    return(
            <div>
                <TiTle />           
                <Top/>
                {/* <Topsmall/> */}
                <Search/>
                <Hot/>
                <Strip/>
                <FirstMiddle name={props.name}/>
            </div>
    );
  }
export default First ;