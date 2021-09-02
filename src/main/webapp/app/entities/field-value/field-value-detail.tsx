import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { getEntity } from './field-value.reducer';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

export const FieldValueDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const fieldValueEntity = useAppSelector(state => state.fieldValue.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="fieldValueDetailsHeading">
          <Translate contentKey="simplifyMarketplaceApp.fieldValue.detail.title">FieldValue</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{fieldValueEntity.id}</dd>
          <dt>
            <span id="value">
              <Translate contentKey="simplifyMarketplaceApp.fieldValue.value">Value</Translate>
            </span>
          </dt>
          <dd>{fieldValueEntity.value}</dd>
          <dt>
            <Translate contentKey="simplifyMarketplaceApp.fieldValue.jobpreference">Jobpreference</Translate>
          </dt>
          <dd>{fieldValueEntity.jobpreference ? fieldValueEntity.jobpreference.id : ''}</dd>
          <dt>
            <Translate contentKey="simplifyMarketplaceApp.fieldValue.field">Field</Translate>
          </dt>
          <dd>{fieldValueEntity.field ? fieldValueEntity.field.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/field-value" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/field-value/${fieldValueEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default FieldValueDetail;
