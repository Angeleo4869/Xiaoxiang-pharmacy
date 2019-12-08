import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';
import Card from '@material-ui/core/Card';
import Avatar from '@material-ui/core/Avatar';
import { deepOrange } from '@material-ui/core/colors';
import Button from '@material-ui/core/Button';
import Tooltip from '@material-ui/core/Tooltip';

const useStyles = makeStyles(theme => ({
  root: {
    padding: theme.spacing(1, 3),
    marginLeft:10,
  },
  cardstyle: {
    position:'relative',
    left:10,
    width:`calc(100vw - 230px)`,
    minWidth:200,
    [theme.breakpoints.down('xs')]: {
        width: '96vw',
    },
  },
  address: {
    width:'100%',
    [theme.breakpoints.down('sm')]: {
      width:250,
    },
  },
  orange: {
    color: '#fff',
    backgroundColor: deepOrange[500],
  },
}));

const longText ='添加新地址';

const ConT =[{name:'折原临也',add:'我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址',num:'1234567890'},
{ name:'平和岛静雄',add:'我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址',num:'1234567890'},
{name:'伊藤健太郎',add:'我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址我是地址',num:'1234567890'},
];
export default function PaperSheet() {
  const classes = useStyles();

  return (
    <div style={{width:'100%'}}>
      <div style={{display:'flex',width:'100%'}}>
          <Typography variant="h6" style={{margin:5,marginLeft:15}} >
              我的地址
          </Typography>
          <Tooltip title={longText} placement="left">
            <Fab color="primary" aria-label="add" style={{position:'absolute',right:10,marginTop:10,height:40,width:40}}>
              <AddIcon />
            </Fab>
          </Tooltip>
      </div>

      <Divider style={{position:'relative',top:10,left:10}}/>
        {ConT.map((text)=>(
          <Card className={classes.cardstyle} style={{height:70,marginTop:20}}>
            <div style={{display:'flex'}}>
              <Avatar className={classes.orange} style={{position:'relative',top:15,left:15}}>{text.name.charAt(0)}</Avatar>
              <div style={{display:'inline'}}>
                <Typography variant="h7" style={{margin:5,marginLeft:30}} >
                  {text.name}
                </Typography>
                <Typography variant="h7" style={{margin:5,marginLeft:30}} >
                  {text.num}
                </Typography>
                <div className={classes.address} style={{margin:5,marginLeft:25}}>
                  <Typography variant="h7" style={{margin:5,position:'relative',top:7}} >
                    {text.add}
                  </Typography>
                </div>
              </div>
              <Divider orientation="vertical" />
              <div style={{display:'flex',position:'absolute',margin:5,marginLeft:15,right:30}}>
                <Button variant="outlined" size="small" color="primary" style={{marginLeft:5,position:'relative',top:15,right:-30}}>
                  编辑
                </Button>
                <Button variant="outlined" size="small" color="secondary" style={{marginLeft:5,position:'relative',top:15,right:-30}}>
                  删除
                </Button>
              </div>
            </div>
          </Card>
        ))} 
    </div>
  );
}