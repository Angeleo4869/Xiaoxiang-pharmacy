import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
const useStyles = makeStyles(theme => ({
    title: {
        dispaly : 'block',
        textAlign: 'center',
        
    },
    safe_warm: {
        position:'relative',
        width:'100%',
        background: '#ffffc7',
    },
    link:{
        color:'#ff0000'
    },
  }));
const Welcome2 = props =>{
    const classes = useStyles();
    return(
        <div className={classes.safe_warm}>
            <div className={classes.title}>
                <span>
                    <a  className={classes.link}
                        href="https://www.baidu.com" 
                        target="_blank"
                        rel="noopener noreferrer">
                        提示
                    </a>
                </span>
            </div>
        </div>
    
    
    );
  }
export default Welcome2;