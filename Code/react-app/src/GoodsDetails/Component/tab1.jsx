import React from 'react';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles({
  root: {
    width: '100%',
    maxWidth: 600,
  },
});

export default function Types(props) {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Typography variant="h3" gutterBottom>
        通用名称：{props.Gdata.goodsComName}
      </Typography>
      <Typography variant="h3" gutterBottom>
        化学名称：{props.Gdata.goodsCheName}
      </Typography>
      <Typography variant="h5" gutterBottom>
        主要成分：{props.Gdata.goodsComposition}
      </Typography>
      <Typography variant="h5" gutterBottom>
        性状：{props.Gdata.goodsCharacter}
      </Typography>
      <Typography variant="h5" gutterBottom>
        规格：{props.Gdata.goodsSpecifications}
      </Typography>
      <Typography variant="h5" gutterBottom>
        用法用量：{props.Gdata.goodsUsage}
      </Typography>
      <Typography variant="h5" gutterBottom>
        禁忌：{props.Gdata.goodsTaboo}
      </Typography>
      <Typography variant="h5" gutterBottom>
        主治功能：{props.Gdata.goodsManufacturer}
      </Typography>
      <Typography variant="h5" gutterBottom>
        保质期：{props.Gdata.goodsValidity}个月
      </Typography>
      <Typography variant="h5" gutterBottom>
        生产日期：{props.Gdata.goodsProductionDate}
      </Typography>
    </div>
  );
}