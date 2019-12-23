import React from 'react';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';
import Card from '@material-ui/core/Card';
import List from '@material-ui/core/List';
import InboxIcon from '@material-ui/icons/MoveToInbox';
import Button from '@material-ui/core/Button';
import Divider from '@material-ui/core/Divider';
import { makeStyles } from '@material-ui/core/styles';
import {Link} from 'react-router-dom';

const useStyles = makeStyles(theme => ({
//控制 width *******
    cardstyle: {
        position:'relative',
        left:10,
        width:`calc(100vw - 230px)`,
        minWidth:200,
        [theme.breakpoints.down('xs')]: {
            width: '96vw',
        },
    },
    cardlist: {
        position:'relative',
        display: 'flex',
        left:10,
        top:10,
        marginBottom:10,
    },
    cardlist2: {
        position:'relative',
        left:10,
        top:10,
        marginBottom:10,
        marginTop:10,        
    },
    textLeft: {
        position:'relative',
        left:10,
        marginTop:9,
        marginBottom:9,
    },
    icontop: {
        position:'absolute',
        right:5,
        marginTop:5
    }
}))

export default function FullWidthTabs(props) {
    const classes = useStyles();
  return (
    <div style={{position:'relative',width:'100%'}}>
        <Typography variant="h5" style={{position:'relative',left:10}}>设置</Typography>
        <Card className={classes.cardstyle}>
                <div style={{display:'flex',width:'100%'}}>
                    <InboxIcon/>
                    <div style={{display:'inline'}}>
                        <Typography>昵称:</Typography>
                        <Typography>会员名</Typography>
                    </div>
                    <Button style={{position:'absolute',right:5}}>编辑</Button>
                </div>
                <Divider light />
                <Link to="/PersonCenter/show/address">
                    <div style={{display:'flex'}}>
                        <Typography  className={classes.textLeft}>我的收货地址</Typography>
                        <InboxIcon className={classes.icontop}></InboxIcon>
                    </div>
                </Link>
        </Card>
        <Link to="/PersonCenter/modify/Revise">
            <Card className={classes.cardlist}>
                <Typography className={classes.textLeft} >账号与安全</Typography>
                <InboxIcon className={classes.icontop}></InboxIcon>
            </Card>
        </Link>
        <Card className={classes.cardlist2}>
            <center>
                <Typography style={{marginBottom:10,marginTop:15}}>退出当前账户</Typography>
            </center>
        </Card>
        <div style={{height:95}}>s</div>{/* 注意一定要加，不然显示不全 */}
    </div>
  );
}
