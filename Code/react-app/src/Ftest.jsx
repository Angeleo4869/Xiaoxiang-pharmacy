import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Date from './GlobalData';
import './GoodsDetails/rotate/data';
import Button from '@material-ui/core/Button';
// import Date from './GlobalData';

export default function funTest(props){
    let ct = [];
    const useStyles = makeStyles(theme => ({
        root: {
          display: 'flex',
          overflowX: 'hidden',
          overflowY: 'hidden',
        },
        
      }));
      const Label = props => <div>{props.tag()}</div> 
      
      const Tag = props => (<div>This is tag<div>asd</div></div>)
      
      const Page = props => <Label tag={Tag}/>
      
      fetch('http://10.136.1.219:8080/React_Manage2/myaction.action')
        .then((response)=>  response.json())
        .then((j) =>{
            console.log(j); 
            var Ts=null;
            Date.setText(j.Len);
            ct=j.Len;
            console.log(Date.text);
            console.log(ct);
                
        })
        
        function getCom(){
            return(
                <div>
                    {ct.map(
                        (index)=>(index)
                    )}
                </div>
            )
        }

    const classes = useStyles();
    
    ;
    // Date.text=["asd","asd"];
    console.log(ct);
    return(
        <div>
            {/* <Button onClick={}>123</Button> */}
            {console.log(ct )}
            <getCom/>
        </div>
    )
}