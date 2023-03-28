package com.example.demo.service;

import com.example.demo.model.JwtRequest;
import java.util.Map;
public interface JwtGeneratorInterface {
Map<String, String> generateToken(JwtRequest user);
}
