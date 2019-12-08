import React, { useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Badge from '@material-ui/core/Badge';
import MailIcon from '@material-ui/icons/Mail';
import { Button } from '@material-ui/core';
import Date from './../GlobalData';
const useStyles = makeStyles(theme => ({
    root: {
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      width: '100%',
    },
    margin: {
      margin: theme.spacing(1),
    },
    divider: {
      margin: theme.spacing(2, 0),
      width: '100%',
    },
    row: {
      marginTop: theme.spacing(2),
    },
  }));
  
  export default function BadgeVisibility(props) {
    const classes = useStyles();  
    
    const [invisible, setInvisible] = React.useState(false);
    const [Bnum,setBnum] = React.useState(Date.Bnum);
    useEffect(
        ()=>(setBnum(Date.Bnum),[])
    )
    const handleBadgeVisibility = () => {
        if(Bnum===0){
            setInvisible(invisible);
        }
        setBnum(Date.Bnum--);
        alert(Date.Bnum)
        // setBum(Bnum);
      };
    return (
        <div>
            <Badge color="secondary" 
            showZero={false} 
            max={99} 
            badgeContent={Bnum}   
            className={classes.margin}>
                <MailIcon />
            </Badge>
            <Button onClick={handleBadgeVisibility}>22</Button>
        </div>
    )
  }