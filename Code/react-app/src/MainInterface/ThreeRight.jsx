import React from 'react';
import { Link } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import Center from 'react-center';
import Fab from '@material-ui/core/Fab';
import Zoom from '@material-ui/core/Zoom';
import useScrollTrigger from '@material-ui/core/useScrollTrigger';
import KeyboardArrowUpIcon from '@material-ui/icons/KeyboardArrowUp';
const defaultProps = {
    bgcolor: 'background.paper',
    // m: 1,
    border: 1,
  };
  
const useStyles = makeStyles(theme => ({
    div:{
        width:650,
        height:360,
        marginTop:40,
    },
    div1:{
        width:650,
        height:360,
    },
    divs:{
        width:216.5,
        height:360,
        marginTop:40,
    },
    divs1:{
        width:216.5,
        height:360,
    },
    divBox:{
        width:216.6,
        height:250,
    },
    dd:{
        marginTop:20,
    },
    ddd:{
        display:'flex',
        height:400,
    },
    dddd:{
        display:'flex',
        height:250,
    },
    link:{
        color:'#ff0000',
    }
}));

const link1={
    color:'#00F000',
}
const link2={
    color:'#000F00',
}
const link3={
    color:'#000000',
}
const link4={
    color:'#000000',
}
const link5={
    color:'#000000',
}
function ScrollTop(props) {
    const { children, window } = props;
    const classes = useStyles();
    // Note that you normally won't need to set the window ref as useScrollTrigger
    // will default to window.
    // This is only being set here because the demo is in an iframe.
    const trigger = useScrollTrigger({
      target: window ? window() : undefined,
      disableHysteresis: true,
      threshold: 100,
    });
  
    const handleClick = event => {
      const anchor = (event.target.ownerDocument || document).querySelector('#back-to-top-anchor');
      if (anchor) {
        anchor.scrollIntoView({ behavior: 'smooth', block: 'center' });
      }
    };
  
    return (
      <Zoom in={trigger}>
        <div onClick={handleClick} role="presentation" className={classes.fixscroll}>
          {children}
        </div>
      </Zoom>
    );
  }
export default function Test(props){
    
    const classes = useStyles();
    const [Links1,setLinks1] = React.useState(link5);
    const [Links2,setLinks2] = React.useState(link5);
    const [Links3,setLinks3] = React.useState(link5);
    const [Links4,setLinks4] = React.useState(link5);
    const [Links5,setLinks5] = React.useState(link5);
    const Links6 = {color:'#FF0000'};
    const [All,setAll] = React.useState(props.name
    );
    const eventContent =[
        {id:Links1,mr:()=>(setLinks1(Links6)),mt:()=>(setLinks1(link5))},
        {id:Links2,mr:()=>(setLinks2(Links6)),mt:()=>(setLinks2(link5))},
        {id:Links3,mr:()=>(setLinks3(Links6)),mt:()=>(setLinks3(link5))},
        {id:Links4,mr:()=>(setLinks4(Links6)),mt:()=>(setLinks4(link5))},
        {id:Links5,mr:()=>(setLinks5(Links6)),mt:()=>(setLinks5(link5))}
    ]
    return(
        <div >
            <div className={classes.ddd}>
            
            {All[0].contX.map((text,index)=>(
                <div className={classes.div} key={index}>
                    <Link to={text.to}><img className={classes.div1} src={text.imgsrc}/></Link>
                </div>
                ))}
                
                {All[0].contY.map((text,index)=>(
                    <div className={classes.divs} key={index}>
                        <Link to={text.to}><img className={classes.divs1} src={text.imgsrc}/></Link>
                    </div>
                ))}
            </div>
            <div className={classes.dddd}>
                {eventContent.map((text,index)=>(
                    <Box key={index} className={classes.divBox} borderColor="#DDDDDD" {...defaultProps}>
                         <Center>
                             <Link to={All[0].contZ[index].to}><img src={All[0].contZ[index].imgsrc}/></Link>   
                         </Center>
                         <div >
                            <Center>
                                <Link style={text.id} onMouseOver={text.mr} onMouseOut={text.mt} to={All[0].contZ[index].to}><Typography noWrap >{All[0].contZ[index].label}</Typography></Link>
                            </Center>
                         </div>
                         <div className={classes.dd}>
                            <Center>
                                <Typography noWrap className={classes.link}>{All[0].contZ[index].money}</Typography>
                            </Center>
                         </div>
                    </Box>
                ))}
                
            </div>
           
        </div>
    );
  }
