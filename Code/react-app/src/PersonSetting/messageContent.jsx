import React from 'react';
import Card from '@material-ui/core/Card';
import Typography from '@material-ui/core/Typography';
import Avatar from '@material-ui/core/Avatar';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles(theme => ({
  fullwid: {
    display:'flex',
    width:`calc(100vw - 430px)`,
  }
}));

export default function tabpanelcontent(props){
    const classes = useStyles();
    const {text} = props;
    // console.log(text)
    return(
    <div style={{width:'100%'}}>
        {text.map(
            (content,index)=>(
                <Card key={index} style={{display:'inline',marginBottom:10,width:'100%'}}>
                  <div>
                  {content.con==='0'?
                  <div className={classes.fullwid}>
                    <Typography align='left' >
                      {index}
                      {content.mess}
                    </Typography>
                    </div>
                    :<span>
                      
                      <Typography align='right' style={{marginRight:50}} >
                        {index}
                        {content.mess}
                      </Typography> </span>
                    }
                  </div>
                </Card>
            )
          )
        }
    </div>
    )
  }