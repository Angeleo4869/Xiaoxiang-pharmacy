import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import Button from '@material-ui/core/Button';
import Divider from '@material-ui/core/Divider';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles(theme => ({
    cardstyle: {
        position:'relative',
        left:10,
        width:`calc(100vw - 230px)`,
        minWidth:200,
        [theme.breakpoints.down('xs')]: {
            width: '96vw',
        },
    },
}));


//setting
export default function SvgIconsColor() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
        <Typography variant="h5" style={{position:'relative',left:15}}>账户与安全</Typography>
        <Card className={classes.cardstyle}>
            <div style={{display:'flex',marginTop:10,marginBottom:7}}>
                <Typography style={{position:'relative',left:5}}>修改登陆密码</Typography>
                <InboxIcon style={{position:'absolute',right:0}}/>
            </div>
        </Card>
        <div style={{height:95}}>s</div>{/* 注意一定要加，不然显示不全 */}
    </div>
  );
}