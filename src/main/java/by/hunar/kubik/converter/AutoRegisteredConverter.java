package by.hunar.kubik.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import javax.annotation.PostConstruct;

public abstract class AutoRegisteredConverter<S, T> implements Converter<S, T> {

  private GenericConversionService conversionService;

  protected ConversionService getConversionService() {
    return conversionService;
  }

  @Autowired
  public void setConversionService(GenericConversionService conversionService) {
    this.conversionService = conversionService;
  }

  @PostConstruct
  protected void register() {
    conversionService.addConverter(this);
  }

}
